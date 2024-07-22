package com.picpaysimplificado.service;

import com.picpaysimplificado.domain.dto.NotificationDto;
import com.picpaysimplificado.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;

@Service
public class NotificationService {
    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user , String message)  throws Exception{
        String email = user.getEmail();
        NotificationDto notificationRequest = new NotificationDto(email, message);
        ResponseEntity<String> notificationResponse= restTemplate.postForEntity("https://util.devi.tools/api/notification", notificationRequest, String.class);

        if (!(notificationResponse.getStatusCode()== HttpStatus.OK)){
            System.out.println("Erro ao enviar notificação");
            throw new Exception("Serviço de notificação encontra-se fora do ar");

        }
    }
}
