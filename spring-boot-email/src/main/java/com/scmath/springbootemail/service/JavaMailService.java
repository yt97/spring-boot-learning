package com.scmath.springbootemail.service;

import com.scmath.springbootemail.vo.MailVo;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Objects;

/**
 * java实现 邮件功能
 *   核心逻辑
 */
@Service
public class JavaMailService {

    @Resource
    private JavaMailSenderImpl mailSender;

    public MailVo send(MailVo vo) {
        try {
            check(vo);
            sendMimeMail(vo);
            return vo;
        } catch (Exception e) {
//            logger.error("发送邮件失败:", e);
            System.err.println(String.format("发送邮件失败:{0}",e));
            vo.setStatus("fail");
            vo.setError(e.getMessage());
            return vo;
        }
    }

    /**
     * 校验 邮件Vo，to、subject、text为必填项，为空拒绝发送
     * @param vo
     */
    private void check(MailVo vo) {
        if (StringUtils.isEmpty(vo.getTo())) {
            throw new RuntimeException("邮件收信人不能为空");
        }
        if (StringUtils.isEmpty(vo.getSubject())) {
            throw new RuntimeException("邮件主题不能为空");
        }
        if (StringUtils.isEmpty(vo.getText())) {
            throw new RuntimeException("邮件内容不能为空");
        }
        //TODO  内容检查，（钓鱼邮件，高危站点，xss，注入等）
    }

    /**
     * 调用 mailSender.send();发送邮件
     * @param vo
     * @return
     */
    private void sendMimeMail(MailVo vo) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

            // Vo必填项：发件人、主送、主题、内容
            vo.setFrom(getMailSendFrom());
            messageHelper.setFrom(vo.getFrom());
            messageHelper.setTo(vo.getTo().split(","));
            messageHelper.setSubject(vo.getSubject());
            messageHelper.setText(vo.getText());

            //抄送
            if (!StringUtils.isEmpty(vo.getCc())) {
                messageHelper.setCc(vo.getCc().split(","));
            }
            //密送
            if (!StringUtils.isEmpty(vo.getBcc())) {
                messageHelper.setCc(vo.getBcc().split(","));
            }
            //附件
            if (vo.getMultipartFiles() != null) {
                for (MultipartFile multipartFile : vo.getMultipartFiles()) {
                    messageHelper.addAttachment(Objects.requireNonNull(multipartFile.getOriginalFilename()), multipartFile);
                }
            }
            //发送时间
            if (StringUtils.isEmpty(vo.getSentDate())) {
                vo.setSentDate(new Date());
                messageHelper.setSentDate(vo.getSentDate());
            }

            mailSender.send(mimeMessage);

            vo.setStatus("ok");
//            logger.info("发送邮件成功：{}->{}", vo.getFrom(), vo.getTo());
            System.out.println(String.format("发送邮件成功：{0}->{1}", vo.getFrom(), vo.getTo()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将邮件 保存，方便统计和追查
     * @param vo
     * @return
     */
    private MailVo save(MailVo vo) {
        //持久化操作
        return vo;
    }

    public String getMailSendFrom() {
        return mailSender.getJavaMailProperties().getProperty("from");
    }
}
