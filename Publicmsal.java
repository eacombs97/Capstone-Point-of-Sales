import com.microsoft.aad.msal4j.*;

import java.net.URI;
import java.util.Set;
import java.util.concurrent.*;
import java.util.Collections;
import java.security.*;
import java.security.cert.CertificateEncodingException;
import java.util.Base64;
public class Publicmsal {
    public static void main(String[] args) throws Exception {
            String clientId = "df9ad17d-483c-4fca-b70d-1e7df2c26e27";
            String authority = "https://bitbuggy.b2clogin.com/tfp/bitbuggy.onmicrosoft.com/B2C_1_BitBuggyLogin";
            Set<String> scopes = Collections.singleton("openid offline_access");
            String redirectUri = "https://bitbuggy.b2clogin.com/tfp/bitbuggy.onmicrosoft.com/B2C_1_BitBuggyLogin"; // Must be registered in Azure portal

            PublicClientApplication app = PublicClientApplication.builder(clientId)
                    .authority(authority)
                    .build();

        InteractiveRequestParameters parameters = InteractiveRequestParameters
                .builder(new URI(redirectUri))
                .scopes(scopes)
                .build();

            // Acquire token interactively
            IAuthenticationResult result = app.acquireToken(parameters).get();

            System.out.println("Access Token: " + result.accessToken());
        }
}
