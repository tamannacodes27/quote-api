package com.tamanna.quote_api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;

@RestController 
public class QuoteController {
    private final QuoteService quoteService;
    public QuoteController(QuoteService quoteService) {
    this.quoteService = quoteService;
}
    @GetMapping("/api/quote")
    public List<Quote> getQuotes() {
        return quoteService.getAllQuotes();
    }
    @GetMapping("/api/quote/{id}")
    public Quote getQuoteById(@PathVariable Long id){
        return quoteService.getQuoteById(id);
    }
    @PostMapping ("/api/quote")
    public Quote createQuote(@RequestBody Quote quote ){
        return quoteService.saveQuote(quote);
    }
    @PutMapping("/api/quote/{id}")
    public Quote updateQuote(@PathVariable Long id,@RequestBody Quote quote){
        return quoteService.updateQuote(id,quote);
    }
    @DeleteMapping ("/api/quote/{id}")
    public String deleteQuote(@PathVariable Long id){
        quoteService.deleteQuote(id);
        return "Quote deleted successfully";
    }
    
}
