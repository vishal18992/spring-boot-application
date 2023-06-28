package com.web.webclient.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.webclient.exceptions.CrmLeadNotFoundException;
import com.web.webclient.model.CrmLeadDto;
import com.web.webclient.repo.CrmLead;
import com.web.webclient.repo.CrmLeadRepository;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class CrmLeadService {

    private final CrmLeadRepository repository;

    public CrmLeadService(CrmLeadRepository repository) {
        this.repository = repository;
    }

    public long add(CrmLeadDto crmLeadDto){
        CrmLead newLead = repository.save(this.toEntity(crmLeadDto));
        return  newLead.getId();
    }

    public List<CrmLead> getLeads(){
        List<CrmLead> leads = new ArrayList<>();
         repository.findAll().forEach(leads::add);
//         repository.findAll().forEach((res) -> leads.add(res) );
         return leads;
    }

    public CrmLead browse(long id) {
        Optional<CrmLead> lead = repository.findById(id);
        return lead.orElseThrow(() -> new CrmLeadNotFoundException("Couldn't find a Lead with id: " + id));
    }

    public String convertMapToJson(Map<String, ?> args) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        String json;
        json = objectMapper.writeValueAsString(args);
        System.out.println(json);
        return json;
    }

    public boolean write(long id, Map<String,?> param) {
        boolean flag = true;
        CrmLead lead = this.browse(id);
        final ObjectMapper mapper = new ObjectMapper();
        try{
            String jsonParam = this.convertMapToJson(param);
            mapper.readerForUpdating(lead).readValue(jsonParam);
        }catch (JsonProcessingException ex){
            System.out.println("JsonProcessingException : Params is not matched..");
            flag= false;
        }
        repository.save(lead);
        return flag;
    }

    public Optional<CrmLead> getLead(long id){
        return repository.findById(id);
    }

    public boolean unlink(long id){
        boolean flag = Boolean.TRUE;
        try {
            repository.deleteById(id);
        }catch (Exception ex){
            flag = Boolean.FALSE;
        }
        return flag;
    }

    private CrmLead toEntity(CrmLeadDto crmLeadDto){
        CrmLead lead = new CrmLead();
        lead.setName(crmLeadDto.getName());
        lead.setEmail(crmLeadDto.getEmail());
        lead.setDescription(crmLeadDto.getDescription());
        lead.setCompany(crmLeadDto.getCompany());
        lead.setPhone(crmLeadDto.getPhone());
        lead.setCompany(crmLeadDto.getCompany());
        return lead;
    }


}
