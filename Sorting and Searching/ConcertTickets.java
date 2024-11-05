import java.io.*;
import java.util.*;

public class ConcertTickets {
    public static void main(String[] args) throws IOException {
        Reader io = new Reader();
        PrintWriter pw = new PrintWriter(System.out);

        int ticketNum = io.nextInt();
        int peopleNum = io.nextInt();
        NavigableMap<Integer, Integer> ticketMultiset = new TreeMap<>();
        Map.Entry<Integer, Integer> val;

        for (int i = 0; i < ticketNum; i++) {
            int priceOfTicket = io.nextInt();
            if (ticketMultiset.containsKey(priceOfTicket)) {
                ticketMultiset.put(priceOfTicket,
                        ticketMultiset.get(priceOfTicket) + 1);
            } else {
                ticketMultiset.put(priceOfTicket, 1);
            }
        }

        for (int i = 0; i < peopleNum; i++) {
            int customerMaxPrice = io.nextInt();
            val = ticketMultiset.lowerEntry(customerMaxPrice + 1);
            if (val != null) {
                pw.println(val.getKey());
                if (val.getValue() == 1) {
                    ticketMultiset.remove(val.getKey());

                } else {
                    ticketMultiset.put(val.getKey(), val.getValue() - 1);
                }
            } else {
                pw.println(-1);
            }
        }
        io.close();
        pw.close();
    }
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null) return;
            din.close();
        }
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do { ret = ret * 10 + c - '0'; } while ((c = read()) >= '0' && c <= '9');

            if (neg) return -ret;
            return ret;
        }
    }
}