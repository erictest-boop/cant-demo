package edu.illinois.library.cantaloupe.util;

import edu.illinois.library.cantaloupe.test.BaseTest;
import org.junit.jupiter.api.Test;

import java.net.ServerSocket;

public class SocketUtilsTest extends BaseTest {

    @Test
    void testGetOpenPort() throws Exception {
        ServerSocket socket = null;
        try {
            int port = SocketUtils.getOpenPort();
            socket = new ServerSocket(port);
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }

    @Test
    void testGetOpenPorts() throws Exception {
        int[] ports = SocketUtils.getOpenPorts(2);

        for (int port : ports) {
            ServerSocket socket = null;
            try {
                socket = new ServerSocket(port);
            } finally {
                if (socket != null) {
                    socket.close();
                }
            }
        }
    }

}
