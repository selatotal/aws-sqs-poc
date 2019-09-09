package br.selat.com.awssnspoc.endpoint;

import br.selat.com.awssnspoc.contract.input.MessageInput;
import br.selat.com.awssnspoc.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/message")
public class UserEndpoint {

    private final MessageService service;

    @Autowired
    public UserEndpoint(MessageService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody MessageInput input){
        return ok(service.sendMessage(input));
    }

}
