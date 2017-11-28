<?xml version="1.0" encoding="iso-8859-1"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

<xsl:template match="/">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="fatura.css" />
	</head>
	<body>
		<p class="numero">Factura nº: <xsl:value-of select="concat(/fatura/@serie,'-',/fatura/@numero)" /></p>
		
		<table>
			<tr>
				<td>Cliente</td>
				<td>
					<xsl:value-of select="/fatura/cliente/nome/text()"/>
				</td>
			</tr>
			<tr>
				<td>Morada</td>
				<td>
					<xsl:value-of select="/fatura/cliente/morada/rua"/>, 
					<xsl:value-of select="/fatura/cliente/morada/codPostal"/> - <xsl:value-of select="/fatura/cliente/morada/localidade"/>, 
					<xsl:value-of select="/fatura/cliente/morada/pais"/>
				</td>
			</tr>
		</table>
		<br />
		<table border="0" width="100%">
			<tr>
				<th>#</th>
				<th>Quantidade</th>
				<th>Designação</th>
				<th>IVA</th>
				<th>Preço unitário</th>
				<th>Total</th>
			</tr>
			<xsl:for-each select="fatura/linhas/linha">
			<xsl:sort select="@numero" order="ascending"/>
				<tr>
					<td>
						<xsl:value-of select="@numero"/>
					</td>
					<td>
						<xsl:value-of select="quantidade"/>
					</td>						
					<td>
						<xsl:value-of select="producto"/>
					</td>					
					<td>
						<xsl:value-of select="preco/@iva"/>%
					</td>
					<td>
						<xsl:value-of select="preco"/>
					</td>
					<td>
						<xsl:value-of select="quantidade * preco + ((quantidade * preco) * (preco/@iva div 100))"/> 
					</td>					
				</tr>
			</xsl:for-each>		
		</table>
		<br/>
		
		<p class="footer">
		Linhas: <xsl:value-of select="count(/fatura/linhas/linha)"/> | Artigos <xsl:value-of select="sum(/fatura/linhas/linha/quantidade)"/> 
		</p>
				
	</body>
</html>
	
</xsl:template>

</xsl:stylesheet>