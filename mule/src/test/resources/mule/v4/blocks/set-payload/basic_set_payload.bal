import ballerina/http;

public type Attributes record {|
    http:Request request;
    http:Response response;
    map<string> uriParams = {};
|};

public type Context record {|
    anydata payload = ();
    Attributes attributes;
|};

public listener http:Listener config = new (8081);

service /mule4 on config {
    resource function get set_payload(http:Request request) returns http:Response|error {
        Context ctx = {attributes: {request, response: new}};

        // set payload
        string payload0 = "Hello world!";
        ctx.payload = payload0;

        ctx.attributes.response.setPayload(ctx.payload);
        return ctx.attributes.response;
    }
}
