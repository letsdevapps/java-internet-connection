# POC Proof of Concept
# PDC Prova de Conceito

Projeto demonstrativo a fim de demonstrar Verificação de Conexão com Internet para aplicativos Java Desktop de diferentes modos.

# Docker

	docker build -t java-internet-connection .
	
	docker run --rm --name java-internet-connection java-internet-connection

# Visão geral

Este POC mostra três abordagens comuns para checar se há acesso à Internet a partir de uma aplicação Java:

* Ping — executa o comando do sistema (ping) via Runtime/ProcessBuilder.
* InetAddress — resolução DNS e (opcional) isReachable() para testar alcançabilidade.
* URLConnection — requisição HTTP (recomenda‑se HEAD) com timeouts.

# HttpURLConnection (recomendado para checagem de internet)

Destaque para o HttpURLConnection como mais recomendado atualmente. Fazer uma requisição HTTP (preferencialmente HEAD) para um host confiável. É mais apropriado para checar conectividade HTTP/HTTPS e permite configurar timeouts.

Boas práticas:
Use HEAD para não baixar o conteúdo.
Configure connect e read timeouts.
Verifique códigos de resposta (200..399 geralmente indicam sucesso).

# Ping

Utilização do mecanismo Runtime para execução do comando ping

	Process process = Runtime.getRuntime().exec("ping -c 1 www.google.com");

Utiliza o comando ping do sistema operacional para testar conectividade. Atenção:
* flags diferentes por SO: -c 1 em Linux/macOS; -n 1 em Windows.
* Pode ser necessário tratar saída/erros do processo.
* Execuções de ping podem ser bloqueadas em ambientes restritos.

	String countFlag = System.getProperty("os.name").toLowerCase().contains("win") ? "-n" : "-c";
    ProcessBuilder pb = new ProcessBuilder(Arrays.asList("ping", countFlag, "1", host));

# InetAddress

Utilização do mecanismo InetAddress para busca por DNS

	InetAddress address = InetAddress.getByName("www.google.com");

ou
	
	InetAddress address = InetAddress.getByName("8.8.8.8");

# HttpURLConnection

Utilização do mecanismo HttpURLConnection para busca por URL

	URL url = new URL("http://www.google.com");
	HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
