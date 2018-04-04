package application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/man")
public class Man {
    private NamedParameterJdbcTemplate template = null;

    public Man(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @RequestMapping(value = "/add_man", method = RequestMethod.GET)
    public ResponseEntity fff_0(@RequestParam(value="man") String man) {

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("man_name", man);
        template.update("INSERT INTO people (man_name) VALUES (:man_name);", params);

        return ResponseEntity.ok("ADDING_OK");
    }
}
