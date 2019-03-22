package org.bag

import org.slf4j.LoggerFactory

class Mailer{
    /**
     * new SmtpClient("smtp.ziggo.nl", 587)
        {
            Credentials = ((ICredentialsByHost) new NetworkCredential("j.frerichs5@upcmail.nl", "Hardcore187!")),
            EnableSsl = true
        }.Send(message);

     */
    val logger = LoggerFactory.getLogger(Mailer::class.java)
    fun jemoer(){
        logger.info("doe dan")
    }
}