package dev.pro.shelter.service.impl;

import dev.pro.shelter.repository.VolunteerRepository;
import dev.pro.shelter.service.VolunteerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class VolunteerServiceImpl implements VolunteerService {
    private final VolunteerRepository repository;
    Random random;

    public VolunteerServiceImpl (VolunteerRepository repository) {
        this.repository = repository;
        this.random = new Random();
    }

    @Override
    public Long getRandomVolunteerChatId() {
        return (new ArrayList<>(repository.findAll()).get(random.nextInt(repository.findAll().size()))).getIdChat();
    }

}
