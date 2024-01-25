package dev.igraciarena.util;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
public final class MessageUtils {
    private MessageUtils() {

    }

    public static String getNotFoundErrorMessage(final String className) {
        return "The " + className + " id " + "that was provided was not found.";
    }

    public static String getCallingServiceMessage(final String serviceName,
                                                  final String className) {
        return "Calling " + serviceName + " to retrieve all orders by "
                + className + " with id: {}";
    }
}
