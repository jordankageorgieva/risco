package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Test5 {
    private static class Record {
        private final int id;
        private final String name;

        private Record(final int id, final String name) {
            super();

            this.id = id;
            this.name = name;
        }
    }


    private static Collection<Record> getInitialDatabase() {
        return new ArrayList<>(Arrays.asList(
                new Record(1, "Jonathan"),
                new Record(2, "Simon"),
                new Record(3, "Sarah"),
                new Record(4, "Steven")));
    }

    private static Collection<Record> removeRecord(Collection<Record> in, int index) {
        List<Record> res = new ArrayList<>();
        
        for (Record record : in) {
            if (record.id != index) {
              res.add(record);
          }
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        Collection<Record> db = removeRecord(getInitialDatabase(), 2);

        if (db.size() != 3) {
            throw new Exception("Failed");
        }

        System.out.println("Succeeded!");
    }
}
