package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

///////////////////////////////////////////////////////////

// НЕОБХОДИМО СЛАТЬ ЗАПРОСЫ С ДРУГОГО СЕРВЕРА
// НЕОБХОДИМО СЛАТЬ ЗАПРОСЫ С ДРУГОГО СЕРВЕРА
// НЕОБХОДИМО СЛАТЬ ЗАПРОСЫ С ДРУГОГО СЕРВЕРА
// НЕОБХОДИМО СЛАТЬ ЗАПРОСЫ С ДРУГОГО СЕРВЕРА
// НЕОБХОДИМО СЛАТЬ ЗАПРОСЫ С ДРУГОГО СЕРВЕРА

///////////////////////////////////////////////////////////

class TwoNumbers {
    TwoNumbers(int aa, int bb, int ss) {
        a = aa;
        b = bb;
        s = ss;
    }

    public int a = 0;
    public int b = 0;
    public int s = 0;
}

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/summa")
public class Summa {
    /**
     * Метод: POST
     * Url запроса: http://localhost:5000/summa/find_summa?rnd=xxxyyyzzz
     * Тело запроса: {"a":550,"b":125}
     */
    @PostMapping(path="/find_summa", produces="application/json")
    public ResponseEntity fff_1(@RequestBody TwoNumbers body) {
        int a = body.a;
        int b = body.b;
        int c = a + b;
        // add to database
        addRecord(a,b,c);
        return ResponseEntity.ok(c);
    }

    /**
     * Метод: GET
     * Url запроса: http://localhost:5000/summa/find_summa?a=25&b=14&rnd=xxyyzz
     */
    @RequestMapping(value = "/find_summa", method = RequestMethod.GET)
    public ResponseEntity fff_2(@RequestParam(value="a") int a, @RequestParam(value="b") int b) {
        int c = a + b;
        // add to database
        addRecord(a,b,c);
        return ResponseEntity.ok(c);
    }


    //////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////

    private NamedParameterJdbcTemplate template = null;

    @Autowired
    public Summa(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public void addRecord(int a, int b, int s) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("a", a);
        params.addValue("b", b);
        params.addValue("s", s);
        template.update("INSERT INTO sum_results (a, b, s) VALUES (:a,:b,:s);", params);
    }

    private RowMapper<TwoNumbers> RECORDS_MAPPER = (res, num) -> new TwoNumbers(
            res.getInt("a"),
            res.getInt("b"),
            res.getInt("s")
    );

    public List<TwoNumbers> getMyRecords() {
        MapSqlParameterSource params = new MapSqlParameterSource();
        List<TwoNumbers> my_records_list = template.query("SELECT a, b, s FROM sum_results ORDER BY record_id DESC;", params, RECORDS_MAPPER);
        return my_records_list;
    }

    /**
     * Метод: GET
     * Url: http://localhost:5000/summa/get_records?rnd=xxyyzz
     */
    @GetMapping(path="/get_records", produces="application/json")
    public ResponseEntity fff_3() {
        List <TwoNumbers> records = getMyRecords();
        return ResponseEntity.ok(records);
    }
}
