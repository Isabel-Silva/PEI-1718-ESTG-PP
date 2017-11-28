<?xml version="1.0"?> 
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

<xsl:template match="/">
	<html>
		<head>
			<title><xsl:value-of select="/cursos/@escola" /></title>
			<link rel="stylesheet" type="text/css" href="conditional_logic.css" />
		</head>
		<body>
			<xsl:for-each select="/cursos/curso">       
				<img><xsl:attribute name="src"><xsl:value-of select="img"/></xsl:attribute></img>
				<h1>
				  <xsl:if test="@disponivel = 'nao'">
					<xsl:attribute name="style">color:#FF0000</xsl:attribute>
				  </xsl:if>
				  <xsl:if test="@disponivel = 'sim'">
					<xsl:attribute name="style">color:#000000</xsl:attribute>
				  </xsl:if>				  
				  <xsl:value-of select="nome"/>
				  <xsl:text> - </xsl:text>
				  <xsl:value-of select="tipo"/>
				</h1>
			</xsl:for-each>
		</body>
	</html>
</xsl:template>

</xsl:stylesheet>
