import com.microsoft.aad.msal4j.*;
import java.util.concurrent.*;
import java.util.Collections;
public class Msal {
    public static void main(String[] args) throws Exception {
        // Define application properties
        String clientId = "df9ad17d-483c-4fca-b70d-1e7df2c26e27";
        String clientSecret = "nIH8Q~XAyXynNDUOyxHqfX3fIGq-HIlWTkRVUcUY";
        String authority = "https://login.microsoftonline.com/533398db-accf-4cf9-bee1-6b65ce5aa8b9";

        // Create ConfidentialClientApplication instance
        ConfidentialClientApplication app = ConfidentialClientApplication.builder(clientId, ClientCredentialFactory.createFromSecret(clientSecret))
                .authority(authority)
                .build();

        // Define authentication parameters
        ClientCredentialParameters parameters = ClientCredentialParameters.builder(Collections.singleton("openid profile email password"))
                .build();

        try {
            // Acquire token asynchronously
            CompletableFuture<IAuthenticationResult> future = app.acquireToken(parameters);

            // Wait for token acquisition to complete and handle response
            IAuthenticationResult result = future.get();

            // Extract access token
            String accessToken = result.accessToken();
            System.out.println("Access token: " + accessToken);
        } catch (ExecutionException | InterruptedException e) {
            // Handle exception
            e.printStackTrace();
        }
    }
}
