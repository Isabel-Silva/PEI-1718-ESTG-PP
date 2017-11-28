<?xml version="1.0"?> 
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  
<xsl:template match="/escola">
<html>
	<head>
		<title><xsl:value-of select="text()" /></title>
		<link rel="stylesheet" type="text/css" href="simpletransform.css" />
	</head>
	<body>
		<img src="../photos/logo.png" />
		<h1><xsl:value-of select="text()" /></h1>
	</body>
</html>
</xsl:template>

</xsl:stylesheet>
