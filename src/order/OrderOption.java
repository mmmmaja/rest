package order;

public enum OrderOption {
    homeDelivery, // Web interface for home delivery
    dineInOnlineOrder, // Dining in and ordering via QR Code
    dineInInPersonOrder, // Dining in and ordering via a server
    APIOrder, // Using external ordering website
}
