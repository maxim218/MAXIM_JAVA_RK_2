package application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

///////////////////////////////////////////////////////////

// НЕОБХОДИМО СЛАТЬ ЗАПРОСЫ С ДРУГОГО СЕРВЕРА
// НЕОБХОДИМО СЛАТЬ ЗАПРОСЫ С ДРУГОГО СЕРВЕРА
// НЕОБХОДИМО СЛАТЬ ЗАПРОСЫ С ДРУГОГО СЕРВЕРА
// НЕОБХОДИМО СЛАТЬ ЗАПРОСЫ С ДРУГОГО СЕРВЕРА
// НЕОБХОДИМО СЛАТЬ ЗАПРОСЫ С ДРУГОГО СЕРВЕРА

///////////////////////////////////////////////////////////

class TwoNumbers {
    public int a = 0;
    public int b = 0;
}

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/summa")
public class Summa {
    /**
     * Метод: Post
     * Url запроса: http://localhost:5000/summa/find_summa?rnd=xxxyyyzzz
     * Тело запроса: {"a":550,"b":125}
     */
    @PostMapping(path="/find_summa", produces="application/json")
    public ResponseEntity fff_1(@RequestBody TwoNumbers body) {
        int a = body.a;
        int b = body.b;
        int c = a + b;
        return ResponseEntity.ok(c);
    }

    /**
     * Метод: GET
     * Url запроса: http://localhost:5000/summa/find_summa?a=25&b=14&rnd=xxyyzz
     */
    @RequestMapping(value = "/find_summa", method = RequestMethod.GET)
    public ResponseEntity fff_2(@RequestParam(value="a") int a, @RequestParam(value="b") int b) {
        int c = a + b;
        return ResponseEntity.ok(c);
    }
}
