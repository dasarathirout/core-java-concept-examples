package org.concept.networking.ex11;

import java.net.InetAddress;
import java.util.logging.Logger;

public class CommunicationProtocol {
    private static Logger LOG = Logger.getLogger(CommunicationProtocol.class.getName());

    /*
     * Socket Communication Protocol:
     * Internet Protocol (IP) :
     * =======================
     * Low-level routing protocol.
     * Breaks data into small packets and sends.
     * Does not guarantee to deliver
     *
     * Transmission Control Protocol (TCP):
     * ====================================
     * Higher-level protocol
     * Robustly string together these packets
     * Sorting and Retransmitting them as necessary to reliably transmit data.
     *
     * User Datagram Protocol (UDP):
     * =============================
     * Kind of TCP and can be used directly to support fast connectionless.
     * Unreliable transport of packets.
     *  */
    public static void main(String[] args) {
        executeNet11();
        executeNet12();
    }

    public static void executeNet11() {

        try {
            InetAddress address = InetAddress.getLocalHost();
            LOG.info(address.getHostAddress());
            LOG.info(address.getCanonicalHostName());
            LOG.info(address.getHostName());
        } catch (Exception ex) {
            LOG.severe(ex.getMessage());
        }
    }

    public static void executeNet12() {

        try {
            InetAddress[] hotStarAddress = InetAddress.getAllByName("www.HotStar.com");
            LOG.info("HotStar : " + hotStarAddress.length);
            for (int i = 0; i < hotStarAddress.length; i++) {
                LOG.info(hotStarAddress[i].toString());
            }

            InetAddress[] netflixAddress = InetAddress.getAllByName("www.Netflix.com");
            LOG.info("Netflix : " + netflixAddress.length);
            for (int i = 0; i < netflixAddress.length; i++) {
                LOG.info(netflixAddress[i].toString());
            }

            InetAddress[] youTubeAddress = InetAddress.getAllByName("www.YouTube.com");
            LOG.info("YouTube : " + youTubeAddress.length);
            for (int i = 0; i < youTubeAddress.length; i++) {
                LOG.info(youTubeAddress[i].toString());
            }
        } catch (Exception ex) {
            LOG.severe(ex.getMessage());
        }
    }

}
