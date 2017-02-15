/**
 * Coviu Session API
 * Coviu provides a session based API for creating and restricting access to coviu calls. The core concepts exposed are* Session: A coviu call that occurs between two or more parties at a specified time, and has a finite duration.* Participants: Users who may participate in a coviu call.Participants join a call by following a session link in their browser, or mobile app. The session link identifiesthe participant, including their name, optional avatar, and importantly their role. As such, it is important thateach person joining the call be issued a different session link, i.e. have a distinct participant created for them.A participant's role identifies whether that user may access the call directly, or if they are required the be let inby an existing participant.
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
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


package com.coviu.sessions.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * ParticipantUpdateRequest
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-02-15T11:45:03.343+11:00")
public class ParticipantUpdateRequest   {
  @SerializedName("state")
  private String state = null;

  @SerializedName("display_name")
  private String displayName = null;

  @SerializedName("role")
  private String role = null;

  @SerializedName("picture")
  private String picture = null;

  public ParticipantUpdateRequest state(String state) {
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public ParticipantUpdateRequest displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

   /**
   * Get displayName
   * @return displayName
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public ParticipantUpdateRequest role(String role) {
    this.role = role;
    return this;
  }

   /**
   * Get role
   * @return role
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public ParticipantUpdateRequest picture(String picture) {
    this.picture = picture;
    return this;
  }

   /**
   * Get picture
   * @return picture
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParticipantUpdateRequest participantUpdateRequest = (ParticipantUpdateRequest) o;
    return Objects.equals(this.state, participantUpdateRequest.state) &&
        Objects.equals(this.displayName, participantUpdateRequest.displayName) &&
        Objects.equals(this.role, participantUpdateRequest.role) &&
        Objects.equals(this.picture, participantUpdateRequest.picture);
  }

  @Override
  public int hashCode() {
    return Objects.hash(state, displayName, role, picture);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParticipantUpdateRequest {\n");
    
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    picture: ").append(toIndentedString(picture)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

