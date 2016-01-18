Simple Java implementation for https://sendgrid.com/docs/API_Reference/Webhooks/event.html;

#How to use:


    1) Create instance :
    
    ```
    private SendGridApi sendGridApi = new SendGridApi();
    
    ```
    
    The ```SendGridApi``` is stateless so, you can create one instance and use it where you want.
    
    2) To read all messages :
    
    
    ```
    WebHookEvents events = sendGridApi.readAll(data);
    
    ```
    
    Where ```WebHookEvents``` is:
    
    ```
    public class WebHookEvents {
        private List<WebHookEvent> events = new ArrayList<>();
    
        public WebHookEvents(WebHookEvent[] events) {
            Collections.addAll(this.events, events);
        }
    
        public WebHookEvents(List<WebHookEvent> events) {
            this.events.addAll(events);
        }
    
        public List<WebHookEvent> getEvents() {
            return events;
        }
    
        public void setEvents(List<WebHookEvent> events) {
            this.events = events;
        }
    }

    ```
    
    and ```WebHookEvent``` is:
    
    ```

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
        
    }

    ```
    
    3) To read first message from list
    
     
    ```
    WebHookEvent event = sendGridApi.readFirst(data);
    
    ```
    
    
    4) To filter messages by some message from list
       
         
    ```
    WebHookEvents events = sendGridApi.filterBy(sendGridApi.readAll(data), EventType.UNSUBSCRIBE);
        
    ```
    Returns list of unsubscribed events.
    