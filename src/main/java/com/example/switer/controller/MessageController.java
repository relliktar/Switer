package com.example.switer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.switer.domain.Message;
import com.example.switer.repos.MessageRepo;

@Controller
@RequestMapping("/message")
@PreAuthorize("hasAuthority('ADMIN')")
public class MessageController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping
    public String messageList(Model model) {
	model.addAttribute("messages", messageRepo.findAll());
	return "messageList";
    }

    @GetMapping("{message}")
    public String messageEditForm(@PathVariable Message message, Model model) {
	model.addAttribute("message", message);
	return "messageEdit";
    }

    @PostMapping
    public String messageSave(@RequestParam String text, @RequestParam String tag, @RequestParam String filename,
	    @RequestParam("messageId") Message message) {
	message.setText(text);
	message.setTag(tag);
	if (filename.length()> 36) {
	    message.setFilename(filename);
	}else message.setFilename(null);
	messageRepo.save(message);
	return "redirect:/message";
    }

}
