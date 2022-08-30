//main.ts is for bootstrapping the root module.

import { enableProdMode } from '@angular/core';

import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { environment } from './environments/environment';

if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic().bootstrapModule(AppModule)//Appmodule is root module.module has components.
  .catch(err => console.error(err));//in case of failures or missing modules
