package br.edu.insper.desagil.alfandega;

import java.util.ArrayList;
import java.util.List;

public class Alfandega {
	private List<Item> itens;
	private List<ItemTarifado> itensTarifados;

	public Alfandega() {
		this.itens = new ArrayList<>();
		this.itensTarifados = new ArrayList<>();
	}

	public void declara(Item item) {
		this.itens.add(item);
	}

	public void declara(ItemTarifado itemTarifado) {
		this.itensTarifados.add(itemTarifado);
	}
	
	private double encontraTotal(String tipo) {
		double total = 0.0;
		if (tipo.equals("declarado")){
			for (Item item : this.itens) {
				total += item.getRate() * item.getValor();
			}
			for (ItemTarifado itemTarifado : this.itensTarifados) {
				total += itemTarifado.getRate() * itemTarifado.getValor();
			}
		}
		if (tipo.equals("devido")){
			for (Item item : this.itens) {
				total += item.getRate() * item.getValor() * 0.01;
			}
			for (ItemTarifado itemTarifado : this.itensTarifados) {
				total += itemTarifado.getRate() * itemTarifado.getValor() * itemTarifado.getTarifa();
			}
		}
		return total;
	}

	public double getTotalDeclarado() {
		double total = encontraTotal("declarado");
		return total;
	}

	public double getTotalDevido() {
		double total = encontraTotal("devido");
		return total;
	}
}
