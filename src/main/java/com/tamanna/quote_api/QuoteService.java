package com.tamanna.quote_api;

import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class QuoteService {

    private final QuoteRepository quoteRepository;

    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public Quote saveQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    public Quote getQuoteById(Long id) {
        return quoteRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Quote not found"
                        ));
    }

    public Quote updateQuote(Long id, Quote quote) {

        Quote existingQuote = quoteRepository.findById(id).orElse(null);

        if (existingQuote == null) {
            return null;
        }

        existingQuote.setQuote(quote.getQuote());
        existingQuote.setAuthor(quote.getAuthor());

        return quoteRepository.save(existingQuote);
    }

    public void deleteQuote(Long id) {
        quoteRepository.deleteById(id);
    }
}