package lapr2.pot.ui.console.utils;

import java.util.Calendar;

public class Date implements Comparable<Date> {

    private int ano;

    private Mes mes;

    private int dia;

    private static final int ANO_POR_OMISSAO = 1;

    private static final Mes MES_POR_OMISSAO = Mes.JANEIRO;

    private static final int DIA_POR_OMISSAO = 1;

    private static enum DiaDaSemana {

        DOMINGO {
            @Override
            public String toString() {
                return "Domingo";
            }
        },
        SEGUNDA {
            @Override
            public String toString() {
                return "Segunda-Feira";
            }
        },
        TERCA {
            @Override
            public String toString() {
                return "Terça-Feira";
            }
        },
        QUARTA {
            @Override
            public String toString() {
                return "Quarta-Feira";
            }
        },
        QUINTA {
            @Override
            public String toString() {
                return "Quinta-Feira";
            }
        },
        SEXTA {
            @Override
            public String toString() {
                return "Sexta-Feira";
            }
        },
        SABADO {
            @Override
            public String toString() {
                return "Sábado";
            }
        };

        public static String designacaoDiaDaSemana(int ordemDiaDaSemana) {
            return DiaDaSemana.values()[ordemDiaDaSemana].toString();
        }
    }

    private static enum Mes {

        JANEIRO(31) {
            @Override
            public String toString() {
                return "Janeiro";
            }
        },
        FEVEREIRO(28) {
            @Override
            public String toString() {
                return "Fevereiro";
            }
        },
        MARCO(31) {
            @Override
            public String toString() {
                return "Março";
            }
        },
        ABRIL(30) {
            @Override
            public String toString() {
                return "Abril";
            }
        },
        MAIO(31) {
            @Override
            public String toString() {
                return "Maio";
            }
        },
        JUNHO(30) {
            @Override
            public String toString() {
                return "Junho";
            }
        },
        JULHO(31) {
            @Override
            public String toString() {
                return "Julho";
            }
        },
        AGOSTO(31) {
            @Override
            public String toString() {
                return "Agosto";
            }
        },
        SETEMBRO(30) {
            @Override
            public String toString() {
                return "Setembro";
            }
        },
        OUTUBRO(31) {
            @Override
            public String toString() {
                return "Outubro";
            }
        },
        NOVEMBRO(30) {
            @Override
            public String toString() {
                return "Novembro";
            }
        },
        DEZEMBRO(31) {
            @Override
            public String toString() {
                return "Dezembro";
            }
        };

        private int numeroDeDias;

        private Mes(int numeroDeDias) {
            this.numeroDeDias = numeroDeDias;
        }

        public int numeroDeDias(int ano) {
            if (ordinal() == 1 && Date.isAnoBissexto(ano)) {
                return numeroDeDias + 1;
            }
            return numeroDeDias;
        }

        public static Mes obterMes(int ordemDoMes) {
            return Mes.values()[ordemDoMes - 1];
        }
    }

    public Date(int ano, int mes, int dia) {
        setData(ano, mes, dia);
    }

    public Date() {
        ano = ANO_POR_OMISSAO;
        mes = MES_POR_OMISSAO;
        dia = DIA_POR_OMISSAO;
    }

    public Date(Date outraData) {
        ano = outraData.ano;
        mes = outraData.mes;
        dia = outraData.dia;
    }

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes.ordinal() + 1;
    }

    public int getDia() {
        return dia;
    }

    public final void setData(int ano, int mes, int dia) {
        if (mes < 1 || mes > 12) {
            throw new InvalidMonthException("Mês " + mes + " é inválido!!");
        }
        if (dia < 1 || dia > Mes.obterMes(mes).numeroDeDias(ano)) {
            throw new InvalidDayException("Dia " + ano + "/" + mes + "/" + dia
                    + " é inválido!!");
        }
        this.ano = ano;
        this.mes = Mes.obterMes(mes);
        this.dia = dia;
    }

    @Override
    public String toString() {
        return String.format("%s, %d de %s de %d", diaDaSemana(), dia, mes, ano);
    }

    public String toAnoMesDiaString() {
        return String.format("%04d/%02d/%02d", ano, mes.ordinal() + 1, dia);
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Date outraData = (Date) outroObjeto;
        return ano == outraData.ano && mes.equals(outraData.mes)
                && dia == outraData.dia;
    }

    @Override
    public int compareTo(Date outraData) {
        return (outraData.isMaior(this)) ? -1 : (isMaior(outraData)) ? 1 : 0;
    }

    public String diaDaSemana() {
        int totalDias = contaDias();
        totalDias = totalDias % 7;

        return DiaDaSemana.designacaoDiaDaSemana(totalDias);
    }

    public boolean isMaior(Date outraData) {
        int totalDias = contaDias();
        int totalDias1 = outraData.contaDias();

        return totalDias > totalDias1;
    }

    public int diferenca(Date outraData) {
        int totalDias = contaDias();
        int totalDias1 = outraData.contaDias();

        return Math.abs(totalDias - totalDias1);
    }

    public int diferenca(int ano, int mes, int dia) {
        int totalDias = contaDias();
        Date outraData = new Date(ano, mes, dia);
        int totalDias1 = outraData.contaDias();

        return Math.abs(totalDias - totalDias1);
    }

    public static boolean isAnoBissexto(int ano) {
        return ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0;
    }

    public static Date dataAtual() {
        Calendar hoje = Calendar.getInstance();
        int ano = hoje.get(Calendar.YEAR);
        int mes = hoje.get(Calendar.MONTH) + 1;    // janeiro é representado por 0.
        int dia = hoje.get(Calendar.DAY_OF_MONTH);
        return new Date(ano, mes, dia);
    }

    private int contaDias() {
        int totalDias = 0;

        for (int i = 1; i < ano; i++) {
            totalDias += isAnoBissexto(i) ? 366 : 365;
        }
        for (int i = 1; i < mes.ordinal() + 1; i++) {
            totalDias += Mes.obterMes(i).numeroDeDias(ano);
        }
        totalDias += dia;

        return totalDias;
    }
}
