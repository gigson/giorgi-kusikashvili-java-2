package ge.btu.giorgi.kusikashvili.currency;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/currency")
@Produces("application/json")
public class CurrencyController {

	private Map<String, Map<String, Object>> exchangeData = new HashMap<>();

	private List<Map<String, Object>> exchangeDataList = new ArrayList<>();

	@PostConstruct
	public void init() {
		Map<String, Object> usdMap = new HashMap<>();
		usdMap.put("title", "USD");
		usdMap.put("buy", 3.16);
		usdMap.put("sell", 3.2);

		Map<String, Object> eurMap = new HashMap<>();
		eurMap.put("title", "EUR");
		eurMap.put("buy", 3.425);
		eurMap.put("sell", 3.4750);


		Map<String, Object> gbpMap = new HashMap<>();
		gbpMap.put("title", "GPB");
		gbpMap.put("buy", 3.84);
		gbpMap.put("sell", 3.94);

		Map<String, Object> rubMap = new HashMap<>();
		rubMap.put("title", "RUB");
		rubMap.put("buy", 4.12);
		rubMap.put("sell", 4.25);


		Map<String, Object> tryMap = new HashMap<>();
		tryMap.put("title", "TRY");
		tryMap.put("buy", 0.4);
		tryMap.put("sell", 0.47);


		Map<String, Object> aznMap = new HashMap<>();
		aznMap.put("title", "AZN");
		aznMap.put("buy", 1.6);
		aznMap.put("sell", 1.84);

		exchangeData.put("USD", usdMap);
		exchangeData.put("EUR", eurMap);
		exchangeData.put("GPB", gbpMap);
		exchangeData.put("RUB", rubMap);
		exchangeData.put("TRY", tryMap);
		exchangeData.put("AZN", aznMap);

		exchangeDataList.add(usdMap);
		exchangeDataList.add(eurMap);
		exchangeDataList.add(gbpMap);
		exchangeDataList.add(rubMap);
		exchangeDataList.add(tryMap);
		exchangeDataList.add(aznMap);
	}

	@GET
	@Path("/getExchangeInfo")
	public Object getExchangeInfo() {
		return exchangeDataList;
	}

	@POST
	@Path("/buy")
	@Consumes(MediaType.APPLICATION_JSON)
	public Object buy(ExchangeRequest request) {
		Map<String, Object> currency = exchangeData.get(request.getCurrency());
		return Double.parseDouble(currency.get("buy").toString()) * request.getAmount();
	}

	@POST
	@Path("/sell")
	@Consumes(MediaType.APPLICATION_JSON)
	public Object sell(ExchangeRequest request) {
		Map<String, Object> currency = exchangeData.get(request.getCurrency());
		return Double.parseDouble(currency.get("sell").toString()) * request.getAmount();
	}

}
