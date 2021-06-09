package com.mohsinkd786;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SystemService {

    public List<String> getUUIds() //throws InterruptedException
    {
        List<String> uuids = new ArrayList<>();
        for (int i = 0; i < 2000000; i++) {
            //Thread.sleep(2000);
            uuids.add(UUID.randomUUID().toString());
        }
        return uuids;
    }
}
