package com.web.webclient.web;


import com.web.webclient.model.CrmLeadDto;
import com.web.webclient.repo.CrmLead;
import com.web.webclient.service.CrmLeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/crm.lead")
public class CrmLeadController {

    @Autowired
    private Environment env;

    @Autowired
    private CrmLeadService crmLeadService;

    @PostMapping
    public long getLeads(@RequestBody CrmLeadDto crmLeadDto){
        return crmLeadService.add(crmLeadDto);
    }

    @GetMapping()
    public List<CrmLead> getLeads(){
        return crmLeadService.getLeads();
    }

    @GetMapping("/{id}")
    public Optional<CrmLead> getLead(@PathVariable long id){
        return crmLeadService.getLead(id);
    }

    @DeleteMapping({"/{id}"})
    public boolean unlink(@PathVariable long id){
        return crmLeadService.unlink(id);
    }

    @PutMapping({"/{id}"})
    public boolean write(@PathVariable long id, @RequestBody Map<String,?> param){
        System.out.println(param);
        return crmLeadService.write(id, param);
    }

}
