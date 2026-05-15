package com.example.demo;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenAiControler {

    private OpenAiChatModel chatclient;

    public OpenAiControler(OpenAiChatModel chatModel) {
        this.chatclient = chatclient.create(chatModel);
    }



    @GetMapping("/api")
    public String getAnswer(@PathVariable String message) {

        ChatResponse chatResponse = chatclient
        .prompt(message)
        .call(null)
        .content();

        System.out.println(chatResponse.getMetadata().getModel());



        String response = chatResponse
        .getResult()
        .getOutput()
        .getText();
        


        return ResponseEntity.ok(response);
    }

}
