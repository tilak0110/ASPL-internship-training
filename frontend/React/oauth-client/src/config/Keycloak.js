import Keycloak from 'keycloak-js';

const keycloak = new Keycloak({
    url: "http://localhost:7080",
    realm: "myrealm",
    clientId: "auth-server",
    pkceMethod: 'S256'
});

export default keycloak;