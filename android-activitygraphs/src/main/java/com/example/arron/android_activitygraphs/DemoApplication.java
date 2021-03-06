/*
 * Copyright (C) 2013 The Dagger Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.arron.android_activitygraphs;

import android.app.Application;
import android.location.LocationManager;
import javax.inject.Inject;

public class DemoApplication extends Application {
  private ApplicationComponent applicationComponent;

  // TODO(cgruber): Figure out a better example of something one might inject into the app.
  @Inject LocationManager locationManager; // to illustrate injecting something into the app.

  @Override public void onCreate() {
    super.onCreate();
    applicationComponent = DaggerApplicationComponent.builder()
        .demoApplicationModule(new DemoApplicationModule(this))
        .build();
  }

  public ApplicationComponent component() {
    return applicationComponent;
  }
}
