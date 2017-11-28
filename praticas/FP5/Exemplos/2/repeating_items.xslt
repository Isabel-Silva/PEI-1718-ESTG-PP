<?xml version="1.0"?> 
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

<xsl:template match="/">
<html>
	<head>
		<title><xsl:value-of select="/cursos/@escola" /></title>
		<link rel="stylesheet" type="text/css" href="repeating_items.css" />
	</head>
	<body>
		<xsl:for-each select="/cursos/curso">
			<img><xsl:attribute name="src"><xsl:value-of select="img" /></xsl:attribute></img>
			<h1>
				<xsl:value-of select="nome" />
				<xsl:text> - </xsl:text>
				<xsl:value-of select="tipo" />
			</h1>
		</xsl:for-each>
	</body>
</html>
</xsl:template>

</xsl:stylesheet>
