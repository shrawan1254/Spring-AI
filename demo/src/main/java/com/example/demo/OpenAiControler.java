package com.example.demo;
import org.springframework.ai.openai.OpenAiChatModel;
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

        String response = chatclient
        .prompt(message)
        .call(null)
        .content();
        


        return "Response with chat client: " +  response;
    }

}
