<?xml version="1.0"?> 
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

<xsl:template match="/">
	<html>
		<head>
			<title><xsl:value-of select="/cursos/@escola" /></title>
			<link rel="stylesheet" type="text/css" href="conditional_logic3.css" />
		</head>
		<body>
			<xsl:for-each select="/cursos/curso">
				<img><xsl:attribute name="src"><xsl:value-of select="img"/></xsl:attribute></img>
				<xsl:choose>
					<xsl:when test="@disponivel = 'nao'">
						<h1 style="color:#FF0000">
							<xsl:value-of select="nome"/>
							<xsl:text> - </xsl:text>
							<xsl:value-of select="tipo"/>
						</h1>
				   </xsl:when>
				   <xsl:when test="@disponivel = 'sim'">
					  <h1 style="color:#00FF00">
						<xsl:value-of select="nome"/>
						<xsl:text> - </xsl:text>
						<xsl:value-of select="tipo"/>
					  </h1>
				   </xsl:when>
				   <xsl:otherwise>
					  <h1 style="color:#000000">
						<xsl:value-of select="nome"/>
						<xsl:text> - </xsl:text>
						<xsl:value-of select="tipo"/>
						</h1>
				   </xsl:otherwise>				   
				</xsl:choose>
			</xsl:for-each>
		</body>
		</html>
	</xsl:template>

</xsl:stylesheet>
