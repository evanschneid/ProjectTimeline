import App from "./App.vue";
import { createApp } from "vue";
import { createRouter } from "./router";
import { createAuth0 } from "@auth0/auth0-vue";
import { library } from "@fortawesome/fontawesome-svg-core";
import { faLink, faUser, faPowerOff } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import authConfig from "../auth_config.json";
import hljs from 'highlight.js/lib/core';
import json from 'highlight.js/lib/languages/json';
import hljsVuePlugin from "@highlightjs/vue-plugin";
import "highlight.js/styles/github.css";
import 'vuetify/styles'
import { createVuetify } from "vuetify"
import * as components from "vuetify/components"
import * as directives from "vuetify/directives"
import { faHouse, faList, faTable, faStar, faPencil } from '@fortawesome/free-solid-svg-icons';
import Datepicker from '@vuepic/vue-datepicker';
import '@vuepic/vue-datepicker/dist/main.css'


hljs.registerLanguage('json', json);

const app = createApp(App);

app.component('Datepicker', Datepicker);


const vuetify = createVuetify({
  components,
  directives,
})

library.add(faLink, faUser, faPowerOff, faHouse, faList, faTable, faPencil);
library.add(faLink, faUser, faPowerOff, faHouse, faList, faTable, faStar);

app
  .use(hljsVuePlugin)
  .use(createRouter(app))
  .use(
    createAuth0({
      domain: authConfig.domain,
      clientId: authConfig.clientId,
      authorizationParams: {
        redirect_uri: 'http://localhost:3000/projects',
      }
    })
  )
  .use(vuetify)
  .component("font-awesome-icon", FontAwesomeIcon)
  .mount("#app");
