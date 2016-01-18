
package com.sendgrid.events.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "email",
        "timestamp",
        "smtp-id",
        "event",
        "category",
        "sg_event_id",
        "sg_message_id",
        "response",
        "attempt",
        "useragent",
        "ip",
        "url",
        "reason",
        "status",
        "asm_group_id"
})
public class WebHookEvent {

    @JsonProperty("email")
    private String email;
    @JsonProperty("timestamp")
    private int timestamp;
    @JsonProperty("smtp-id")
    private String smtp_id;
    @JsonProperty("event")
    private String event;
    @JsonProperty("category")
    private String category;
    @JsonProperty("sg_event_id")
    private String sg_event_id;
    @JsonProperty("sg_message_id")
    private String sg_message_id;
    @JsonProperty("response")
    private String response;
    @JsonProperty("attempt")
    private String attempt;
    @JsonProperty("useragent")
    private String useragent;
    @JsonProperty("ip")
    private String ip;
    @JsonProperty("url")
    private String url;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("status")
    private String status;
    @JsonProperty("asm_group_id")
    private int asm_group_id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("timestamp")
    public int getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("smtp-id")
    public String getSmtp_id() {
        return smtp_id;
    }

    @JsonProperty("smtp-id")
    public void setSmtp_id(String smtp_id) {
        this.smtp_id = smtp_id;
    }

    @JsonProperty("event")
    public String getEvent() {
        return event;
    }

    @JsonProperty("event")
    public void setEvent(String event) {
        this.event = event;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("sg_event_id")
    public String getSg_event_id() {
        return sg_event_id;
    }

    @JsonProperty("sg_event_id")
    public void setSg_event_id(String sg_event_id) {
        this.sg_event_id = sg_event_id;
    }

    @JsonProperty("sg_message_id")
    public String getSg_message_id() {
        return sg_message_id;
    }

    @JsonProperty("sg_message_id")
    public void setSg_message_id(String sg_message_id) {
        this.sg_message_id = sg_message_id;
    }

    @JsonProperty("response")
    public String getResponse() {
        return response;
    }

    @JsonProperty("response")
    public void setResponse(String response) {
        this.response = response;
    }

    @JsonProperty("attempt")
    public String getAttempt() {
        return attempt;
    }

    @JsonProperty("attempt")
    public void setAttempt(String attempt) {
        this.attempt = attempt;
    }

    @JsonProperty("useragent")
    public String getUseragent() {
        return useragent;
    }

    @JsonProperty("useragent")
    public void setUseragent(String useragent) {
        this.useragent = useragent;
    }

    @JsonProperty("ip")
    public String getIp() {
        return ip;
    }

    @JsonProperty("ip")
    public void setIp(String ip) {
        this.ip = ip;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("asm_group_id")
    public int getAsm_group_id() {
        return asm_group_id;
    }

    @JsonProperty("asm_group_id")
    public void setAsm_group_id(int asm_group_id) {
        this.asm_group_id = asm_group_id;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebHookEvent that = (WebHookEvent) o;

        if (timestamp != that.timestamp) return false;
        if (asm_group_id != that.asm_group_id) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (smtp_id != null ? !smtp_id.equals(that.smtp_id) : that.smtp_id != null) return false;
        if (event != null ? !event.equals(that.event) : that.event != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (sg_event_id != null ? !sg_event_id.equals(that.sg_event_id) : that.sg_event_id != null) return false;
        if (sg_message_id != null ? !sg_message_id.equals(that.sg_message_id) : that.sg_message_id != null)
            return false;
        if (response != null ? !response.equals(that.response) : that.response != null) return false;
        if (attempt != null ? !attempt.equals(that.attempt) : that.attempt != null) return false;
        if (useragent != null ? !useragent.equals(that.useragent) : that.useragent != null) return false;
        if (ip != null ? !ip.equals(that.ip) : that.ip != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (additionalProperties != null ? !additionalProperties.equals(that.additionalProperties) : that.additionalProperties != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + timestamp;
        result = 31 * result + (smtp_id != null ? smtp_id.hashCode() : 0);
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (sg_event_id != null ? sg_event_id.hashCode() : 0);
        result = 31 * result + (sg_message_id != null ? sg_message_id.hashCode() : 0);
        result = 31 * result + (response != null ? response.hashCode() : 0);
        result = 31 * result + (attempt != null ? attempt.hashCode() : 0);
        result = 31 * result + (useragent != null ? useragent.hashCode() : 0);
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + asm_group_id;
        result = 31 * result + (additionalProperties != null ? additionalProperties.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WebHookEvent{" +
                "email='" + email + '\'' +
                ", timestamp=" + timestamp +
                ", smtp_id='" + smtp_id + '\'' +
                ", event='" + event + '\'' +
                ", category='" + category + '\'' +
                ", sg_event_id='" + sg_event_id + '\'' +
                ", sg_message_id='" + sg_message_id + '\'' +
                ", response='" + response + '\'' +
                ", attempt='" + attempt + '\'' +
                ", useragent='" + useragent + '\'' +
                ", ip='" + ip + '\'' +
                ", url='" + url + '\'' +
                ", reason='" + reason + '\'' +
                ", status='" + status + '\'' +
                ", asm_group_id=" + asm_group_id +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
