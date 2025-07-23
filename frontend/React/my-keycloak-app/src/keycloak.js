import Keycloak from "keycloak-js";

const keycloak = new Keycloak({
  url: "http://localhost:7080/",
  realm: "myrealm",
  clientId: "react-client",
});

export default keycloak;
