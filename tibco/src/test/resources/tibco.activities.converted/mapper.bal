function activityExtension(Context cx) returns error? {
    xml var0 = getFromContext(cx, "InputVariable");
    xml var1 = check xslt:transform(var0, xml`<?xml version="1.0" encoding="UTF-8"?><xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:tns="http://fundtech.com/SCL/CommonTypes" xmlns:tns1="http://www.vietcombank.com.vn/framework/utilities/pattern/pattern/1.0" version="2.0"><xsl:param name="Start"/><xsl:template name="Template" match="/"><xsl:copy-of select="$Start/root/msg"/></xsl:template></xsl:stylesheet>`, cx.variables);
    xml var2 = xml`<root>${var1}</root>`;
    addToContext(cx, "OutputVariable", var2);
}
