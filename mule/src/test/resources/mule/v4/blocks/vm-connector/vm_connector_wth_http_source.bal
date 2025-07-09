import ballerina/http;
import ballerina/log;

public type InboundProperties record {|
    http:Request request;
    http:Response response;
    map<string> uriParams = {};
|};

public type Context record {|
    anydata payload = ();
    InboundProperties inboundProperties;
|};

public listener http:Listener listener_config = new (8083);

service /mule4 on listener_config {
    resource function get vm(http:Request request) returns http:Response|error {
        Context ctx = {inboundProperties: {request, response: new}};
        worker W returns error? {
            // VM Listener
            anydata receivedPayload = <- function;
            ctx.payload = receivedPayload;
            vmReceive0(ctx);
        }

        // set payload
        string payload0 = "Hello World!";
        ctx.payload = payload0;

        // VM Publish
        ctx.payload -> W;

        ctx.inboundProperties.response.setPayload(ctx.payload);
        return ctx.inboundProperties.response;
    }
}

public function vmReceive0(Context ctx) {
    log:printInfo(string `Received a message: ${ctx.payload.toString()}`);
}
