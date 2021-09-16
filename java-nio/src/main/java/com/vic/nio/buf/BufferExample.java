package com.vic.nio.buf;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class BufferExample {

    public static void checkAttribute(Buffer buf) {
        //Get buffer Max
        System.out.println("Capacity - " + buf.capacity());
        //Get limit;
        System.out.println("Limit - " + buf.limit());
        //Get Mark
        System.out.println("Mark - " + buf.mark());
        //Get position
        System.out.println("Position - " + buf.position());
    }

    public static void main(String[] args) {
        ByteBuffer directBuf = ByteBuffer.allocateDirect(1024);
        ByteBuffer buf = ByteBuffer.allocate(1024);

        System.out.println(buf.hasArray());
        System.out.println(directBuf.hasArray());


        checkAttribute(directBuf);
        checkAttribute(buf);
        System.out.println();
        System.out.println("--- Start Write---");
        //Write
        CharBuffer cb = buf.asCharBuffer();
        cb.put("Test");
        checkAttribute(cb);

        System.out.println("--- End write---");
        System.out.println("--- Read ---");
        cb.flip();
        System.out.println("Buffer toString - " + cb.toString());
        StringBuilder sb = new StringBuilder();
        cb.mark();
        System.out.println("Start get character");
        while (cb.hasRemaining()) {
            sb.append(cb.get());
        }
        System.out.println("String builder - " + sb.toString());
        System.out.println("Buffer toString - " + cb.toString());
        cb.reset();
        System.out.println("Buffer toString - " + cb.toString());
        checkAttribute(cb);
    }
}
