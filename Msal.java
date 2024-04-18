import com.microsoft.aad.msal4j.*;
import java.util.concurrent.*;
import java.util.Collections;
public class Msal {
    ConfidentialClientApplication app = ConfidentialClientApplication.builder(
                    "df9ad17d-483c-4fca-b70d-1e7df2c26e27",
                    ClientCredentialFactory.createFromSecret("nIH8Q~XAyXynNDUOyxHqfX3fIGq-HIlWTkRVUcUY"))
                    .authority("https://bitbuggy.b2clogin.com/tfp/bitbuggy.onmicrosoft.com/B2C_1_BitBuggyLogin")
                    .build();

    ClientCredentialParameters parameters =
            ClientCredentialParameters.builder(Collections.singleton("openid profile email password offline_access"))
                    .build();

    CompletableFuture<IAuthenticationResult> future = app.acquireToken(parameters);
    IAuthenticationResult result = future.get();

    String accessToken = result.accessToken();

        System.out.println("Access token: " + accessToken);
}
