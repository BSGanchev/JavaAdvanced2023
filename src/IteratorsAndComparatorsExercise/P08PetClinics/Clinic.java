package IteratorsAndComparatorsExercise.P08PetClinics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

    public class Clinic<Pet> implements Iterable<Pet> {

        private List<Pet> rooms;
        private int size;
        private int used;
        private int centre;

        public Clinic(int rooms) {
            this.setRooms(rooms);
        }

        private void setRooms(int rooms) {
            if (rooms % 2 == 0) {
                throw new IllegalArgumentException("Invalid Operation!");
            }

            this.rooms = new ArrayList<>();
            for (int i =0;i<rooms;i++){
                this.rooms.add(null);
            }
            this.used = 0;
            this.size = rooms;
            this.centre = rooms / 2;
        }

        public boolean add(Pet pet) {
            int currentRoom = centre;

            int step = 0;
            int stepsTaken = 0;
            boolean goLeft = true;
            while (this.rooms.get(currentRoom) != null && step <= this.rooms.size() / 2) {
                if (goLeft) {
                    currentRoom = this.centre - step;
                } else {
                    currentRoom = this.centre + step;
                }

                goLeft = !goLeft;

                stepsTaken++;
                if (stepsTaken == 2) {
                    step++;
                    stepsTaken = 0;
                }
            }

            if (this.rooms.get(currentRoom) == null) {
                this.rooms.set(currentRoom, pet);
                this.used++;
                return true;
            }

            return false;
        }

        public boolean release() {
            if (this.rooms.get(centre) != null) {
                this.rooms.set(centre, null);
                this.used--;
                return true;
            } else if(this.size > 1) {
                int currentRoom = centre + 1;
                while (this.rooms.get(currentRoom) == null && currentRoom != centre) {
                    currentRoom = ++currentRoom % this.rooms.size();
                }

                if (this.rooms.get(currentRoom) != null) {
                    this.rooms.set(currentRoom, null);
                    this.used--;
                    return true;
                }
            }
            return false;
        }

        public String print(){
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= this.size;i++){
                sb.append(print(i));
                sb.append("\n");
            }
            return sb.toString();
        }

        public String print(int room){
            if(this.rooms.get(room - 1) == null){
                return "Room empty";
            }else{
                return this.rooms.get(room - 1).toString();
            }
        }

        public boolean hasEmptyRooms(){
            return this.used != this.size;
        }

        @Override
        public Iterator<Pet> iterator() {
            if(this.rooms.size() == 0){
                return Collections.<Pet>emptyIterator();
            }

            return this.rooms.iterator();
        }

        @Override
        public void forEach(Consumer<? super Pet> action) {
            for (Pet pet : this.rooms){
                action.accept(pet);
            }
        }
    }