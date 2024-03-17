import toys.Toy;
import toys.impl.HotWheels;
import toys.impl.TechnoPark;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Toy> toyList = new ArrayList<>();

        Toy hW1 = new HotWheels(1, "Kinght Draggin", 10);
        Toy hW2 = new HotWheels(2, "Rockin Railer", 15);
        Toy hW3 = new HotWheels(3, "Layin Lowrider", 20);
        Toy hW4 = new HotWheels(4, "Fire car", 70);
        Toy hW5 = new HotWheels(5, "Lonely monster", 30);

        Toy uaz1 = new TechnoPark(6, "2110", 50);
        Toy uaz2 = new TechnoPark(7, "2112", 12);
        Toy uaz3 = new TechnoPark(7, "2109", 14);
        Toy uaz4 = new TechnoPark(7, "2108", 21);
        Toy uaz5 = new TechnoPark(7, "2107", 54);

        toyList.add(hW1);
        toyList.add(hW2);
        toyList.add(hW3);
        toyList.add(hW4);
        toyList.add(hW5);
        toyList.add(uaz1);
        toyList.add(uaz2);
        toyList.add(uaz3);
        toyList.add(uaz4);
        toyList.add(uaz5);

        int[] id = new int[toyList.toArray().length];
        String[] name = new String[toyList.toArray().length];
        int[] fr = new int[toyList.toArray().length];


        for (int i = 0; i < toyList.toArray().length; i++){
            Toy toy = toyList.get(i);
            id[i] = toy.getId();
            name[i] = toy.getName();
            fr[i] = toy.getFreq();
        }

        Queue<Toy> queue = new PriorityQueue<>(Comparator.comparingInt(Toy::getFreq));
        for (int i = 0; i < toyList.toArray().length; i++){
            Toy toy = new Toy(id[i], name[i], fr[i]);
            queue.offer(toy);
        }

        System.out.println(queue);


        try (PrintWriter writer = new PrintWriter(new File("result.txt"))){
            for (int i = 0; i < 10; i++) {
                Toy toy = queue.poll();
                writer.println(toy.getId() + " " + toy.getName() + " " + toy.getFreq());

            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}