/*-
 * -\-\-
 * docker-client
 * --
 * Copyright (C) 2016 Spotify AB
 * --
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * -/-/-
 */

package com.spotify.docker.client.messages;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import java.util.Date;
import javax.annotation.Nullable;

@AutoValue
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public abstract class ContainerState {

  @Nullable
  @JsonProperty("Status")
  public abstract String status();

  @JsonProperty("Running")
  public abstract Boolean running();

  @JsonProperty("Paused")
  public abstract Boolean paused();

  @Nullable
  @JsonProperty("Restarting")
  public abstract Boolean restarting();

  @JsonProperty("Pid")
  public abstract Integer pid();

  @JsonProperty("ExitCode")
  public abstract Integer exitCode();

  @JsonProperty("StartedAt")
  public abstract Date startedAt();

  @JsonProperty("FinishedAt")
  public abstract Date finishedAt();

  @Nullable
  @JsonProperty("Error")
  public abstract String error();

  @Nullable
  @JsonProperty("OOMKilled")
  public abstract Boolean oomKilled();

  @JsonCreator
  static ContainerState create(
      @JsonProperty("Status") final String status,
      @JsonProperty("Running") final Boolean running,
      @JsonProperty("Paused") final Boolean addr,
      @JsonProperty("Restarting") final Boolean restarting,
      @JsonProperty("Pid") final Integer pid,
      @JsonProperty("ExitCode") final Integer exitCode,
      @JsonProperty("StartedAt") final Date startedAt,
      @JsonProperty("FinishedAt") final Date finishedAt,
      @JsonProperty("Error") final String error,
      @JsonProperty("OOMKilled") final Boolean oomKilled) {
    return new AutoValue_ContainerState(status, running, addr, restarting, pid, exitCode,
        startedAt, finishedAt, error, oomKilled);
  }
}
