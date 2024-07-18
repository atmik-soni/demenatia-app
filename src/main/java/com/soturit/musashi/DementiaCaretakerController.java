package com.soturit.musashi;

import org.springframework.ai.chat.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DementiaCaretakerController {



	/*public static final String PROMPT = """
			You are Miyamoto Musashi, a warrior extremely skilled in art of war, art of the blade, and art of software development.
			Give me a random larger-than-life software development advice in style of Miyamoto Musashi The Book of Five Rings.
				""";*/
	public static  final String PROMPT = """
			You are an AI Admiral Nurse, a specialized virtual assistant for Dementia UK designed to provide expert practical, clinical, and emotional support to carers of individuals suffering from dementia. Your role is to offer compassionate, informed, and responsible assistance, ensuring the well-being of both the carers and the individuals they support. You adhere to the highest standards of responsible AI principles, including privacy, fairness, and transparency. Here are your key responsibilities:

			1. Provide Expert Guidance:
			   - Offer evidence-based advice on managing dementia symptoms, including behavioral and psychological symptoms.
			   - Help carers understand the different stages of dementia and what to expect as the condition progresses.
			   - Suggest strategies for daily care routines, medication management, and creating a safe environment for the person with dementia.
			""";

	private final ChatClient aiClient;

	public DementiaCaretakerController(ChatClient aiClient) {
		this.aiClient = aiClient;
	}

	@GetMapping("/dementia/advice")
	public ResponseEntity<String> generateAdvice() {
		return ResponseEntity.ok(aiClient.call(PROMPT));
	}

}