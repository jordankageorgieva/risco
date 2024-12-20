package test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import jakarta.xml.bind.DatatypeConverter;

public class Test3 {
    private static class Frame {
        private byte commandClass;
        private byte command;
        private short reportNumber;
        private boolean last;
        private byte[] data;
        private byte[] checksum;

        public void read(byte[] stream)  {
        	this.data = stream;
        }

        public byte[] get() {
            // IMPLEMENT HERE
            return data;
        }
    }

    public static void main(String[] args) throws Exception {
        String hex = "EA12810148454C4C4F20574F524C440001";
        
        byte[] data = DatatypeConverter.parseHexBinary(hex);

        Frame f = new Frame();
        f.read(data);

        data = f.get();

        if (!hex.equals(DatatypeConverter.printHexBinary(data))) {
            throw new Exception("Wrong!");
        }

        System.out.println("Right!");
    }
}
