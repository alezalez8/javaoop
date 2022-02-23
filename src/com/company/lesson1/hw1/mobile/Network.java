package com.company.javaoop.lesson1.hw1.mobile;

import java.util.ArrayList;
import java.util.List;

class Network {
    private List<Phone> listPhones = new ArrayList<>();

    public Network() {
    }

    public void registrationPhone(Phone phone) {
        if (listPhones.contains(phone)) {
            System.out.println("This number " + phone.getPhoneNumber() +
                    " has already registered");
            return;
        }
        listPhones.add(phone);
    }

    public List<Phone> getListPhones() {
        return listPhones;
    }

    public Phone findPhone(String numberPhone) {
        for (Phone phone : listPhones
        ) {
            if (phone.getPhoneNumber().equals(numberPhone)) {
                return phone;
            }
        }
        return null;
    }

}
