package service;

import model.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MenuService {

    private List<MenuItem> menu=new ArrayList<>();

    public void addItem(MenuItem item){
        menu.add(item);
    }

    public void showMenu(){

        for(MenuItem item:menu){

            System.out.println(item.getId()+" - "+item.getName()+" - "+item.getPrice());

        }

    }

    public List<MenuItem> searchByName(String name){

        return menu.stream()
                .filter(i->i.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());

    }

    public List<MenuItem> searchByPrice(double min,double max){

        return menu.stream()
                .filter(i->i.getPrice()>=min && i.getPrice()<=max)
                .collect(Collectors.toList());

    }

    public MenuItem findById(String id){

        for(MenuItem item:menu){

            if(item.getId().equals(id)){
                return item;
            }

        }

        return null;
    }

}